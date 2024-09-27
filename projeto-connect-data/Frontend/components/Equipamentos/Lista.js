import React, { useState } from 'react';

import { View, Image, ScrollView } from 'react-native';

import { SafeAreaView } from 'react-native-safe-area-context';

import { TouchableRipple, Title, Divider, ActivityIndicator, Text, Button, FAB, Snackbar } from 'react-native-paper';

import { Rounded, Icon, useSignal, useEmit, useEffect, useRequest, map } from '../../lib';

import settings from '../../settings.json';

import styles from '../../styles/Equipamentos/Lista.json';


export default function Lista(props) {
    const { navigation } = props;

    return (
        <>
            <ScrollView>
                <SafeAreaView style={styles.container}>
                <TouchableRipple style={styles.itemContainer} onPress={() => navigation.navigate('equipamentos')}>
                <View style={styles.item}>
                    <Rounded>
                        <View style={styles.photoContainer}>
                                <Icon name="Wall" />
                        </View>
                    </Rounded>
                    <Title style={styles.name}>
                       Equipamentos
                    </Title>
                </View>
            </TouchableRipple>
            <Divider />
                </SafeAreaView>
            </ScrollView>
        )
                ) 

        </>
    );
}