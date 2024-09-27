//imports necessários
import React, { useState, useEffect } from 'react';
import { View, Image, ScrollView, Dimensions } from 'react-native';
import { SafeAreaView } from 'react-native-safe-area-context';
import { TouchableRipple, Title, Divider, ActivityIndicator, Text, Button, FAB, Snackbar, Paragraph } from 'react-native-paper';
import {
  LineChart,
  BarChart,
  PieChart
} from "react-native-chart-kit";
import styles from '../../styles/inicio/Produtividade.json' ;

//função principal
export default function Dashboard(props) {
  const { navigation } = props;
  const colors = ['#7b4173', '#a55194', '#ce6dbd', '#de9ed6'];
  const [dataGraficos, setDataGraficos] = useState([]);
  const [dataGraficosPie, setDataGraficosPie] = useState([]);
  const [loadingData, setLoadingData] = useState(true);
//função para selecionar valores arbitrários para a paleta de cores do gráfico de pizza
  function getRandomArbitrary(min=0, max=255) {
    return Math.round(Math.random() * (max - min) + min);
  }
//Atualiza banco de dados e endpoints
  useEffect(() => {
    async function getEquipamentos() {
      await fetch('http://localhost:8000/equipamento/list', {
        method: 'GET',
        headers: {
          'accept': 'application/json'
        }
      }).then(async res => await res.json())
      .then(equip => {
        let data = {
          labels: equip.map((maquina) => maquina.nome),
          datasets: [
            {
              data: equip.map((maquina) => maquina.horas),
              color: (opacity = 1) => `rgba(134, 65, 244, ${opacity})`,
              strokeWidth: 2 
            }
          ]
        } 
        setDataGraficos(data);

        let dataPie = equip.map((maquina) => {
          let time = parseFloat(maquina.horas);
          time = parseFloat(time.toFixed(2));
          return {
            name: maquina.nome,
            time: time,
            color: `rgb(${getRandomArbitrary()},${getRandomArbitrary()}, ${getRandomArbitrary()})`,
            legendFontColor: "#7F7F7F",
            legendFontSize: 15
          }
        });
        setDataGraficosPie(dataPie);
        
        setLoadingData(false);
      });
    }
    getEquipamentos();
  }, []);
//parametros gráfico de pizza  
  const params_pie={
    backgroundColor: "#e26a00",
    backgroundGradientFrom: "#fb8c00",
    backgroundGradientTo: "#ffa726",
    decimalPlaces: 2,
    color: (opacity = 1) => `rgba(255, 255, 255, ${opacity})`,
    labelColor: (opacity = 1) => `rgba(255, 255, 255, ${opacity})`,
    style: {
        borderRadius: 13
    },
    propsForDots: {
        r: "6",
        strokeWidth: "2",
        stroke: "#ffa726"
    }      
  }
  const screenWidth = Dimensions.get("window").width; // pegando a dimensão da tela usando método do react-native
//retorno da função (tela propriamente dita) 
  return(
    <ScrollView>
      <View style={styles.container}>
      
        <Text style={styles.text}> Horas Utilizadas X Máquina</Text>
         
        {loadingData ? null : (
          <LineChart 
            data={dataGraficos}
            width={screenWidth}
            height={300}
            chartConfig={{
              backgroundColor: "#e26a00",
              backgroundGradientFrom: "#fb8c00",

              backgroundGradientTo: "#ffa726",
              color: (opacity = 1) => `rgba(255, 255, 255, ${opacity})`,
              labelColor: (opacity = 1) => `rgba(255, 255, 255, ${opacity})`,
              style: {
                borderRadius: 16
              },
              propsForDots: {
                r: "6",
                strokeWidth: "2",
                stroke: "#ffa726"
              },
              propsForLabels: {
                rotate: 0
              }
            }}
            withVerticalLabels={true}
          />
        )}

        <Text style={styles.text}> Horas Utilizadas X Máquina</Text>
         
        {loadingData ? null : (<PieChart
          data={dataGraficosPie}
          width={screenWidth}
          height={220}
          chartConfig={params_pie}
          accessor={"time"}
          backgroundColor={"transparent"}
          hasLegend={true}
          paddingLeft={"15"}
          center={[5, 20]}
          absolute
        /> )}
         
         {/* botoes no final da tela */}
          <View style={styles.buttonContainer}>
            <View >
              <Button style={styles.button} 
                      mode="outlined" 
                      onPress={() => navigation.navigate('Tela', null)}>
                  Tela
              </Button>
                       
            </View>            
            <View >
              <Button style={styles.button} 
                      mode="outlined" 
                      onPress={() => navigation.navigate('Especificacoes', null)}>
                  Voltar
              </Button>
                       
            </View>
          </View>
      </View>

  </ScrollView>
  );
} 



        



