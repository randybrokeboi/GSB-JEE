/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function generGraph(typeGraph, laList, listSect, listDate, anneeRevolu){
    if(typeGraph == "1"){
        //données du graph
        var data = {
            //nom des données
            labels: listSect,
            datasets: [{
                label: 'Nombre de Rapport',
                data: laList,
                backgroundColor: 'rgba(255, 99, 132)'
            }]
        }
        //option 
        var option = {
            legend :{
                labels:{
                    defaultFontColor: 'black',
                    defaultFontSize: '20'
                }
            },
            scales: {
                yAxes: [{
                    ticks: {
                        beginAtZero: true

                    }
                }]
            },
            responsive: false
        }

        //config
        var config = {
            //type de graph
            type: 'bar',
            //données du graph
            data: data,
            //option du graph
            options: option
        }
        //init le graph
        var ctx = document.getElementById('myGraph').getContext('2d')
        var graph = new Chart(ctx, config)
    }
    else if(typeGraph == "2"){
        //données du graph
        var data = {
            //nom des données
            labels: listSect,
            datasets: [
                {
                label: 'Nombre de Rapport de Janvier',
                data: laList[0],
                backgroundColor: 'rgba(99, 99, 132)'
            },
            {
                label: 'Nombre de Rapport de Fevrier',
                data: laList[1],
                backgroundColor: 'rgba(20, 99, 25)'
            },
            {
                label: 'Nombre de Rapport de Mars',
                data: laList[2],
                backgroundColor: 'rgba(123, 220, 50)'
            },
            {
                label: 'Nombre de Rapport de Avril',
                data: laList[3],
                backgroundColor: 'rgba(52, 231, 122)'
            },
            {
                label: 'Nombre de Rapport de Mai',
                data: laList[4],
                backgroundColor: 'rgba(222, 111, 25)'
            },
            {
                label: 'Nombre de Rapport de Juin',
                data: laList[5],
                backgroundColor: 'rgba(25, 25, 25)'
            },
            {
                label: 'Nombre de Rapport de Juillet',
                data: laList[6],
                backgroundColor: 'rgba(56, 42, 212)'
            },
            {
                label: 'Nombre de Rapport de Aout',
                data: laList[7],
                backgroundColor: 'rgba(223, 233, 232)'
            },
            {
                label: 'Nombre de Rapport de Septembre',
                data: laList[8],
                backgroundColor: 'rgba(56, 200, 150)'
            },
            {
                label: 'Nombre de Rapport de Octobre',
                data: laList[9],
                backgroundColor: 'rgba(255, 150, 25)'
            },
            {
                label: 'Nombre de Rapport de Novembre',
                data: laList[10],
                backgroundColor: 'rgba(132, 132, 132)'
            },
            {
                label: 'Nombre de Rapport de Decembre',
                data: laList[11],
                backgroundColor: 'rgba(253, 23, 210)'
            }
        ]
        
        }
        //option 
        var option = {
            legend :{
                labels:{
                    defaultFontColor: 'black',
                    defaultFontSize: '20'
                }
            },
            scales: {
                yAxes: [{
                    ticks: {
                        beginAtZero: true

                    }
                }]
            },
            responsive: false
        }

        //config
        var config = {
            //type de graph
            type: 'bar',
            //données du graph
            data: data,
            //option du graph
            options: option
        }
        //init le graph
        var ctx = document.getElementById('myGraph').getContext('2d')
        var graph = new Chart(ctx, config)
    }
    else if(typeGraph == "3"){
        //données du graph
        var data = {
            //nom des données
            labels: listDate,
            datasets: [{
                label: 'Nombre de Rapport',
                data: laList,
                backgroundColor: 'rgba(255, 99, 132)'
            }]
        }
        //option 
        var option = {
            legend :{
                labels:{
                    defaultFontColor: 'black',
                    defaultFontSize: '20'
                }
            },
            scales: {
                yAxes: [{
                    ticks: {
                        beginAtZero: true

                    }
                }]
            },
            responsive: false
        }

        //config
        var config = {
            //type de graph
            type: 'bar',
            //données du graph
            data: data,
            //option du graph
            options: option
        }
        //init le graph
        var ctx = document.getElementById('myGraph').getContext('2d')
        var graph = new Chart(ctx, config)
    }
    else if(typeGraph == "4"){
        //données du graph
        var data = {
            //nom des données
            labels: ["JANVIER", "FEVRIER", "MARS", "AVRIL", "MAI", "JUIN", "JUILLET", "AOUT", "SEPTEMBRE", "OCTOBRE", "NOVEMBRE", "DECEMBRE"],
            datasets: [{
                label: 'Nombre de Rapport',
                data: laList,
                backgroundColor: 'rgba(255, 99, 132)'
            }]
        }
        //option 
        var option = {
            legend :{
                labels:{
                    defaultFontColor: 'black',
                    defaultFontSize: '20'
                }
            },
            scales: {
                yAxes: [{
                    ticks: {
                        beginAtZero: true

                    }
                }]
            },
            responsive: false
        }

        //config
        var config = {
            //type de graph
            type: 'bar',
            //données du graph
            data: data,
            //option du graph
            options: option
        }
        //init le graph
        var ctx = document.getElementById('myGraph').getContext('2d')
        var graph = new Chart(ctx, config)
    }
    else if(typeGraph == "5"){
        //données du graph
        var data = {
            //nom des données
            labels: ["JANVIER", "FEVRIER", "MARS", "AVRIL", "MAI", "JUIN", "JUILLET", "AOUT", "SEPTEMBRE", "OCTOBRE", "NOVEMBRE", "DECEMBRE"],
            datasets: [{
                label: 'Nombre de Rapport',
                data: laList,
                backgroundColor: 'rgba(255, 99, 132)'
            }]
        }
        //option 
        var option = {
            legend :{
                labels:{
                    defaultFontColor: 'black',
                    defaultFontSize: '20'
                }
            },
            scales: {
                yAxes: [{
                    ticks: {
                        beginAtZero: true

                    }
                }]
            },
            responsive: false
        }

        //config
        var config = {
            //type de graph
            type: 'bar',
            //données du graph
            data: data,
            //option du graph
            options: option
        }
        //init le graph
        var ctx = document.getElementById('myGraph').getContext('2d')
        var graph = new Chart(ctx, config)
    }
}