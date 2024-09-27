//imports necessários
import React, { useState ,useEffect} from 'react';
import { ScrollView, Image, View } from 'react-native';
import { SafeAreaView } from 'react-native-safe-area-context';
import { ActivityIndicator, TouchableRipple, TextInput, HelperText, Button, Snackbar,Title } from 'react-native-paper';
import { Icon, InputView, AspectView, DropDown, DateTimePicker, useEmit, useStorage, useRequest } from '../../lib';

import settings from '../../settings.json';
import styles from '../../styles/inicio/Formulario.json';

//verifica se existe equipamento e chave(key)
function exists(equipamento, key) {
    return equipamento !== null && typeof equipamento[key] === 'string';
}
//funcao principal
export default function Formulario(props) {
    //constantes necessárias(useState)
    const { navigation } = props;
    const equipamento=props.route.params;
    const [name,setName] = useState(exists(equipamento,'nome')? 
                            equipamento.nome :'');
    const[model,setModel] = useState(exists(equipamento,'modelo')? 
                            equipamento.modelo: '');
    const [local,setlocal] = useState(exists(equipamento,'local') ? 
                            equipamento.local : 'Roraima');
    const [setor,setSetor] = useState(exists(equipamento,'setor') ? 
                            equipamento.setor : 'Construção');
    const [categoria,setCategoria] = useState(exists(equipamento,'categoria') ? 
                            equipamento.categoria : 'Mecânico');
    const [FabricationDate, setFabricationDate] = useState(exists(equipamento,'ano de fabricacao') ? 
                            new Date(equipamento.ano) : new Date());

    
    const [registerError, setRegisterError] = useState(false);
    const [removeError, setRemoveError] = useState(false);
   
    const emit = useEmit('updated-equipamento');
    
    const { post, put, response: registerResponse } = useRequest(settings.url);
    const {del,response:removeResponse}=useRequest(settings.url);

    useEffect(() => {
        if ((registerResponse.success && registerResponse.body !== null) 
            || (removeResponse.success && removeResponse.body !== null)) 
                {
                emit();
                navigation.navigate('Equipamentos');
            }   
        else {
            navigation.setOptions({ title: equipamento === null ? 'Novo equipamento' : equipamento.nome });
        }
    }, [registerResponse, removeResponse]);
 //funcao assincrona que atualiza cadastro e edicao de equipamentos no banco de dados 
    async function onPressRegister() {
        let ano = FabricationDate.toDateString();
        ano = parseInt(ano.split(' ')[3]);

        setRegisterError(true);
        const body = {
            nome: name,
            modelo: model,
            anoAquisicao: ano,
            local: local,
            setor: setor,
            categoria: categoria,
            horas: 0.0
        };
                    
        if (equipamento === null) {
            const rawResponse = await fetch('http://localhost:8000/equipamento', {
                method: 'POST',
                headers: {
                    'Accept': 'application/json',
                },
                body: JSON.stringify(body)
            });
            const content = await rawResponse.json();
            if (content.key){
                navigation.navigate('Equipamentos', content);
            }  
        } 
        else {
            put('/equipamento', body);
        }
    } 
    

    function onPressRemove(){
        setRemoveError(true);
        del(`/equipamento?key=${equipamento.key}`);
    }
 //cosntantes de erro  
    const nameError=name.trim()==='';
    const modelError=model.trim()==='';
//constantes necessárias ao DropDown
    const localizacao = [
        { label: 'Parana', value: 'PARANA' },
        { label: 'Roraima', value: 'RORAIMA' },
        {label: 'Curitiba', value: 'CURITIBA'},
    ];

    const interno = [
        { label: 'Construção', value: 'CONSTRUCAO' },
        { label: 'Demolição', value: 'DEMOLICAO' }
    ];

    const tipo = [
        { label: 'mecânico', value: 'MECANICO' },
        { label: 'Elétrico', value: 'ELETRICO' },
        { label: 'Térmico', value: 'TERMICO' },
    ];
    
 //retorno da função (tela propriamente dita)
    return (
        <>
            <Title style={styles.title}>Cadastro de novo equipamento</ Title>
        
    <ScrollView>
        <SafeAreaView 
            style={styles.container} 
            edges={['right', 'bottom', 'left']}>        
            
            <TextInput 
                style={styles.input} 
                label="Equipamento" 
                value={name}   
                error={nameError} 
                onChangeText={setName} 
                
            />
            {nameError && (
                <HelperText style={styles.error} type="error">
                    Insira o nome da Máquina
                </HelperText>
            )}


            <TextInput 
                style={styles.input} 
                label="Modelo" 
                value={model}  
                error={modelError} 
                onChangeText={setModel} 
                
            />
            {modelError && (
                <HelperText style={styles.error} type="error">
                    Insira o Modelo da Máquina
                </HelperText>
            )}

            {<DateTimePicker 
                type="date" 
                style={styles.input} 
                label="Data de Fabricação" 
                value={FabricationDate} 
                setValue={setFabricationDate} 
            /> }
            
            <DropDown 
                style={styles.input} 
                label="Estado" 
                list={localizacao} 
                value={local} 
                setValue={setlocal}
                http-equiv="Content-Type" 
                content="text/html; charset=utf-8" 
            />
            
            <DropDown 
                style={styles.input}
                label="local da obra" 
                list={interno} 
                value={setor} 
                setValue={setSetor} 
                http-equiv="Content-Type" 
                content="text/html; charset=utf-8"
            />
            
            <DropDown 
                style={styles.input} 
                label="Tipo de equipamento" 
                list={tipo} 
                value={categoria} 
                setValue={setCategoria}
                http-equiv="Content-Type" 
                content="text/html; charset=utf-8"  
            />
                        
            <View style={styles.buttons}>
                <Button 
                    style={styles.button} 
                    mode="outlined" 
                    disabled={nameError || modelError || registerResponse.running || removeResponse.running} 
                    loading={registerResponse.running} 
                    onPress={onPressRegister} >
                        {equipamento===null ? 'Cadastrar' : 'Atualizar'}
                </Button>

                {equipamento !== null && (
                    <Button 
                        style={styles.button} 
                        mode="outlined" 
                        disabled={removeResponse.running || registerResponse.running} 
                        loading={removeResponse.running} 
                        onPress={onPressRemove}
                    >    
                        Remover
                    </Button> 
                )}
                <Button 
                    style={styles.button} 
                    mode="outlined" 
                    onPress={() => navigation.navigate('Equipamentos', null)} 
                >
                    Voltar
                </Button>
            </View>
        </SafeAreaView>       
    </ScrollView>
                
    {!registerResponse.running && !registerResponse.success && (
        <Snackbar   visible={registerError} 
                    action={{ label: 'Ok', onPress: () => setRegisterError(false) }} 
                    onDismiss={() => { }}>
                    
            { registerResponse.body.status > 0 && `ERROR 
            ${registerResponse.body.status}:`}{registerResponse.body.message}
                
        </Snackbar>
    )}
            
    {!removeResponse.running && !removeResponse.success && (
                
        <Snackbar   visible={removeError} 
                    action={{ label: 'Ok', onPress: () => setRemoveError(false) }} 
                    onDismiss={() => { }}>
                    
            {removeResponse.body.status > 0 && `ERROR 
            ${removeResponse.body.status}:` }
            {removeResponse.body.message}
                
        </Snackbar>
    )}
    </>
    );
}

