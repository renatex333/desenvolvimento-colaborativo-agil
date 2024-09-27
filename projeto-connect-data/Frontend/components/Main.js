import React from 'react';

import { createStackNavigator } from '@react-navigation/stack';

import { useTheme } from 'react-native-paper';

import Inicio from './inicio/Main';

import styles from '../styles/Main.json';

const Stack = createStackNavigator();

export default function Main(props) {
    const theme = useTheme();

    return (
        <Stack.Navigator initialRouteName="ConnectData" screenOptions={theme.screenOptions}>
            <Stack.Screen name="ConnectData" component={Inicio}/>
        </Stack.Navigator>
    );
}
