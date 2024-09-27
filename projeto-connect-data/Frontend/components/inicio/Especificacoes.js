import React, { useState } from 'react';

import { ScrollView, Image, View, NavigatorIOS } from 'react-native';

import { SafeAreaView } from 'react-native-safe-area-context';

import { Title,TouchableRipple, Text, Divider, Portal, ActivityIndicator, FAB, Surface, TextInput, HelperText, List, IconButton, Dialog, Paragraph, Button, Snackbar} from 'react-native-paper';

import { DateTimePicker,Rounded, AspectView,DropDown, Icon, useEmit, useEffect, useCamera, useRequest, map ,useGlobal,useSignal} from '../../lib';

import settings from '../../settings.json';

import styles from '../../styles/inicio/Especificacoes.json';
import { list } from 'postcss';
import { FileSystemUploadType } from 'expo-file-system';


//verifica se existe o equipamento e respectiva chave(key)
function exists(equipamento, key) {
    return equipamento !== null && typeof equipamento[key] === 'string';
}
export default function Especificacoes({route,navigation}) {
    //constantes necessárias
    const { navigate } = navigation;
    const equipamento=route.params;

    const [msgErro, setMsgErro] = useState('');
    
    const [maquina, setMaquina] =useState(exists(equipamento,'nome')? equipamento.nome :'');
    const [usuario,setusuario] = useState(exists(equipamento,'usuario')? equipamento.usuario :'');
    const [andar, setAndar] = useState(exists(equipamento,'andar')? equipamento.andar :'térreo');
    const [horas, setHoras] = useState(exists(equipamento,'horas') ? new Date(equipamento.horas) : new Date());
    
    const Andar = [
        { label: 'Térreo', value: 'Térreo' }, 
        { label: '1° andar', value: '1° andar' },
        { label: '2° andar', value: '2° andar' }
    ]
    
    const [registerError, setRegisterError] = useState(false);
    const [removeError, setRemoveError] = useState(false);   
//useRequest conecta backend
    const { get,del,post, put, response} = useRequest(settings.url);
    
    const signal = useSignal("updated-equipamento");
    const [getError,setGetError]=useState(false);

    useEffect(() => {
        setGetError(true);
        get('/equipamento');
    },[signal]);

//funcao assincrona que atualiza o banco de dados a cada atualização das especificações do Equipamento
    async function onPressRegister() {
        setMsgErro('');
        let timeHora = horas.getHours();
        let timeMinuto = horas.getMinutes();

        const tempoTotal = parseFloat(timeHora) + parseFloat(timeMinuto)/60 +equipamento.horas;

        const body = {
            usuario: usuario,
            nome: equipamento.nome,
            modelo: equipamento.modelo,
            anoAquisicao: equipamento.anoAquisicao,
            horas: tempoTotal,
            categoria: equipamento.categoria,
            andar: andar,
            setor: equipamento.setor,
            local: equipamento.local,
            key: equipamento.key
        };

        await fetch(`http://localhost:8000/equipamento?key=${equipamento.key}`, {
            method: 'PUT',
            headers: {
                'Accept': 'application/json',
            },
            body: JSON.stringify(body)
        })
        .then((res) => {
            navigation.navigate('Produtividade');
        })
        .catch((err) => {
            setMsgErro('Ocorreu algum erro.');
        });

    }
    
//retorno da função(tela propriamente dita)
    return (
        <>
            <ScrollView>
               
                <View style={styles.container}>     
                    <Title style={styles.title}>Especificações do Equipamento</Title>   
                    
                    <View style={styles.inpuTextContainer} >  
                        <Paragraph style={styles.text}>
                            {equipamento?.nome || navigation.navigate('Tela')}
                        </Paragraph>
                        <TextInput 
                            style={styles.Paragraph} 
                            label="Operador Responsavel" 
                            value={usuario} 
                            setValue={setusuario}
                            onChangeText={setusuario} 
                            onPress={onPressRegister}
                            http-equiv="Content-Type" 
                            content="text/html; charset=utf-8"

                        />
                        <DropDown   
                            style={styles.drop} 
                            list={Andar} 
                            value={andar} 
                            setValue={setAndar} 
                            http-equiv="Content-Type" 
                            content="text/html; charset=utf-8" 
                           
                        />
                        <DateTimePicker  
                            type="time" 
                            style={styles.date}
                            label="Horas de Uso" 
                            value={horas} 
                            setValue={setHoras} 
                        /> 

                        {msgErro ? (
                            <Paragraph>{msgErro}</Paragraph>
                        ) : null }
                    </View>  
                
                    <View style={styles.buttonContainer}>
                        <View >
                            <Button 
                                style={styles.button} 
                                mode="outlined" 
                                onPress={onPressRegister}>
                                    Enviar
                            </Button>    
                        </View>            
                        <View >     
                            <Button 
                                style={styles.button} 
                                mode="outlined" 
                                onPress={() => navigation.navigate('Equipamentos', null)}>
                                    Voltar
                            </Button>        
                        </View>

                    </View>
                </View>  
            </ScrollView>
    
            {!response.running && !response.success && (
                <Snackbar   
                    visible={getError} 
                        action={{ label: 'Ok', onPress: () => setGetError(false) }} 
                        onDismiss={() => { }}>
                    
                    {   
                        response.body.status > 0 ? 'Não foi possível conectar ao servidor' : `ERROR 
                        ${response.body.status}: ${response.body.message}`
                    }
                </Snackbar>
            )}   
        </>
    );
}