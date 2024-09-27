//imports necessários
import React, { useState,useEffect }  from 'react';
import { View, Image, ScrollView } from 'react-native';
import { SafeAreaView } from 'react-native-safe-area-context';
import { TouchableRipple, Title, Divider, ActivityIndicator, Text, Button, FAB, Snackbar, Paragraph } from 'react-native-paper';
import { AspectView,Rounded, Icon, useSignal, map,useEmit,  useRequest} from '../../lib';

import styles from '../../styles/inicio/Equipamentos.json';
import settings from '../../settings.json';




//função principal
export default function Equipamentos({ route, navigation }) {
    const { navigate } = navigation;
    const keyNovoEquipamento = route.params;

    const { get, response } = useRequest(settings.url);
    const emit=useEmit("updated-equipamento");
    const signal = useSignal("updated-equipamento");
    const [getError,setGetError]=useState(false);
    const [data, setData] = useState([]);

//atualiza banco de dados e endpoints
    useEffect(() => {
        async function getEquipamentos() {
            await fetch('http://localhost:8000/equipamento/list', {
                method: 'GET',
                headers: {
                    'accept': 'application/json'
                }
            }).then(async res => await res.json())
            .then(equip => {
                setData(equip);
            });
        }
        getEquipamentos();
    }, []);
//atualiza cadastro ou edição de equipamento no banco de dados e endpoints    
    useEffect(() => {
        async function getNovoEquipamento() {
            await fetch(`http://localhost:8000/equipamento?key=${keyNovoEquipamento.key}`, {
                method: 'GET',
                headers: {
                    'accept': 'application/json'
                }
            }).then(async res => await res.json())
            .then(equip => {
                setData([...data, equip]);
            });
        }
        if (keyNovoEquipamento !== undefined && keyNovoEquipamento !== null) {
            getNovoEquipamento();
        }
    }, [keyNovoEquipamento]);


 //retorno da função (tela propriamente dita)
    return (
        <>
            {data.map((item) => (
                <TouchableRipple  
                    key={item.key} 
                    style={styles.itemContainer} 
                    onPress={() => navigate('Especificacoes', item)}
                >
                    <View style={styles.item}>
                        <Rounded>
                            <View style={styles.photoContainer}>
                                <Icon name="hand-saw" /> 
                            </View>
                        </Rounded>
                        <View style={styles.div}>
                            <Title style={styles.name}>
                                    {item.nome}
                            </Title>
                            <Paragraph>
                                    {item.modelo}
                            </Paragraph>
                        </View>
                    </View>
                </TouchableRipple>
            ))}
         
            <View >
                <Button 
                    style={styles.button} 
                    mode="outlined" 
                    onPress={() => navigate('Tela', null)}>
                        Voltar
                </Button>
                       
            </View>

        <FAB    style={styles.fab} 
                icon="plus" 
                onPress={() => navigate('Formulario', null)} />
        
        {!response.running && !response.success && (
                <Snackbar   visible={getError} 
                            action={{ label: 'Ok', onPress: () => setGetError(false) }} onDismiss={() => { }}>
        
        {response.body.status === 0 ? 'Não foi possível conectar ao servidor' : `ERROR 
        ${response.body.status}: ${response.body.message}`}
                </Snackbar>
            )}
        </>
    );
}