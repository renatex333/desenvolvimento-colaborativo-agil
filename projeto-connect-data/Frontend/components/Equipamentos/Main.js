import React from 'react';

import { createStackNavigator } from '@react-navigation/stack';

import { useTheme } from 'react-native-paper';

import Lista from './Lista';
import Ficha from './Ficha';

import styles from '../../styles/Equipamentos/Main.json';

const Stack = createStackNavigator();

export default function Main(props) {
    const theme = useTheme();

    return (
        <Stack.Navigator initialRouteName="Inicio" screenOptions={theme.screenOptions}>
            <Stack.Screen name="Inicio" component={Lista} options={{ headerShown: false }} />
            <Stack.Screen name="equipamentos" component={Ficha} />
        </Stack.Navigator>
    );
}