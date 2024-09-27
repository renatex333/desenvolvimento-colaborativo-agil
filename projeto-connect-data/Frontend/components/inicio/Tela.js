
import React, { useState } from 'react';

import { View, Image, ScrollView } from 'react-native';

import { SafeAreaView } from 'react-native-safe-area-context';

import { TouchableRipple, Title, Divider, ActivityIndicator, Text, Button, FAB, Snackbar } from 'react-native-paper';

import { Rounded, Icon, useSignal, useEmit, useEffect, useRequest, map } from '../../lib';

import settings from '../../settings.json';

import styles from '../../styles/inicio/Tela.json';


export default function Tela(props) {
    const { navigation } = props;

    return (
        <>
            <TouchableRipple style={styles.itemContainer} onPress={() => navigation.navigate('Equipamentos')}>
                <View style={styles.item}>
                    <Rounded>
                        <View style={styles.photoContainer}>
                                <Icon name="circular-saw" /> 
                        </View>
                    </Rounded>
                    <Title style={styles.name}>
                        Equipamentos
                    </Title>
                </View>
            </TouchableRipple>
            <Divider />
            <TouchableRipple style={styles.itemContainer} onPress={() => navigation.navigate('Produtividade', null)}>
                <View style={styles.item}>
                    <Rounded>
                        <View style={styles.photoContainer}>
                                <Icon name="chart-line" /> 
                        </View>
                    </Rounded>
                    <Title style={styles.name}>
                        Gráficos de Produtividade
                    </Title>
                </View>
            </TouchableRipple>
            <Divider />
        </>
    );
}