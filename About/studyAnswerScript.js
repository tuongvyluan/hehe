

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

$(document).ready(function () {

    // select multiple choice 
    $('li.answer-select').click(function (e) {
        $(this).toggleClass('selected').siblings().removeClass('selected');
        if (!$(e.target).is('input[type="checkbox"]')) {
            var $checkbox = $(this).find('input[type="checkbox"]');
            $checkbox.prop('checked', !$checkbox.prop('checked'));
        }
    })
    $('input[type="checkbox"]').on('change', function () {
        $('input[type="checkbox"]').siblings().prop('checked', false);
    })
})

function check() {
    if (document.getElementById('answer').checked == true) {
        alert("checked");
    } else {
        alert("You didn't check it! Let me check it for you.");
    }
}

//reset the selection
document.getElementById('reset').addEventListener('click', () => {
    var selectedAnswer = document.querySelectorAll(".selected");
    for (var i = 0; i < selectedAnswer.length; i++) {
        selectedAnswer[i].className = "answer-select";
    }
})

//submit the answer
function submitAnswers() {
    var form = document.getElementById('answerForm');
    form.submit();
}