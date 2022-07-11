

// ✅ Change (replace) the text for question
// div.innerHTML = `<span style="background-color: lime">Replacement HTML</span>`;

//  //Functions to open database and to create, insert data into tables

//  getSelectedRow = function(val)
//     {
//         db.transaction(function(transaction) {
//               transaction.executeSql('SELECT * FROM Employ where number = ' + parseInt(val, 10) + ';',[], selectedRowValues, errorHandler);

//         });
//     };
//     selectedRowValues = function(transaction,results)
//     {
//          for(var i = 0; i < results.rows.length; i++)
//          {
//              var row = results.rows.item(i);
//              alert(row['number']);
//              alert(row['name']);                 
//          }
//     };

//reset the selection
document.getElementById('reset').addEventListener('click', () => {
    var selectedAnswer = document.querySelectorAll(".selected");
    for (var i = 0; i < selectedAnswer.length; i++) {
        selectedAnswer[i].className = "answer-select";
    }
    var checkboxes = document.querySelectorAll("input");
    for (var checkbox of checkboxes) {
        checkbox.checked = false;
    }
}
})

//setInterval((checkTargetValue), 100);
//
//function checkTargetValue() {
//    var checkboxes = document.querySelectorAll("input");
//    var selectedAnswer = document.querySelectorAll(".selected");
//    for (var i = 0; i < selectedAnswer.length; i++) {
//        if (selectedAnswer[i].className = "answer-select") {
//
//        }
//    }
//}

//submit the answer
function submitAnswers() {
    var form = document.getElementById('answerForm');
    form.submit();
}