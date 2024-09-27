import React from 'react';

import { createStackNavigator } from '@react-navigation/stack';

import { useTheme } from 'react-native-paper';

import Tela from './Tela';
import Equipamentos from './Equipamentos';
import Formulario from './Formulario';
import Especificacoes from './Especificacoes';
import styles from '../../styles/inicio/Main.json';
import Produtividade from '../inicio/Produtividade';

const Stack = createStackNavigator();

export default function Main(props) {
    const theme = useTheme();

    return (
        <Stack.Navigator initialRouteName="Tela" screenOptions={theme.screenOptions}>
            <Stack.Screen name="Tela" component={Tela} options={{ headerShown: false }}/>
            <Stack.Screen name="Equipamentos" component={Equipamentos} options={{ headerShown: false }}/>
            <Stack.Screen name="Formulario" component={Formulario} options={{ headerShown: false }}/>
            <Stack.Screen name="Especificacoes" component={Especificacoes} options={{ headerShown: false }}/>
            
            <Stack.Screen name="Produtividade" component={Produtividade} options={{ headerShown: false }}/>
        </Stack.Navigator>
    );
}
