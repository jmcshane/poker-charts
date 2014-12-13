function createChart(inputData) {
    var json = inputData;
    console.log(inputData);

    var len = json.length
    i = 0
    j = 0;

    var options = {
    	title: {
    		text:"Poker Winnings",
    		x: -20
    	},
    	yAxis: {
    		title: {
    			text: "Winnings ($)"
    		}
    	},
        xAxis: {
            categories: []
        },
        legend: {
            layout: 'vertical',
            align: 'right',
            verticalAlign: 'middle',
            borderWidth: 0,        	
            itemHiddenStyle: {
                color: 'grey'
            }
        },
        series: []
    }

    for (i; i < len; i++) {
        options.series.push(json[i]);
        if (i == 0) {
        	for (j; j < json[i].data.length;j++) {
        		options.xAxis.categories.push("Week" + (j+1));
        	}
        }
    }



    $('#container').highcharts(options);
}
//
//function createChart(dataFactory) {
//    $('#container').highcharts({
//        title: {
//            text: 'Poker Winnings',
//            x: -20 //center
//        },
//        xAxis: {
//            categories: ['Jan', 'Feb', 'Mar', 'Apr', 'May']
//        },
//        yAxis: {
//            title: {
//                text: 'Earnings ($)'
//            },
//            plotLines: [{
//                value: 0,
//                width: 1,
//                color: '#808080'
//            }]
//        },
//        tooltip: {
//            valuePrefix: '$'
//        },
//        legend: {
//            layout: 'vertical',
//            align: 'right',
//            verticalAlign: 'middle',
//            borderWidth: 0
//        },
//        series: []
//    });
//}