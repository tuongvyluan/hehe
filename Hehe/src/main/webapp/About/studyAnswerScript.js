

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

//multiple choice handler
$(document).ready(function () {
    var ans = 2;
    switch (ans) {
        case 1:     // single select
            $('li.answer-select').click(function (e) {
                $(this).toggleClass('selected').siblings().removeClass('selected');
                if (!$(e.target).is('input[type="checkbox"]')) {
                    var $checkbox = $(this).find('input[type="checkbox"]');
                    $checkbox.prop('checked', !$checkbox.prop('checked'));
                    selectOnlyThis($checkbox.prop('id'));
                }
            })
            break;
        case 2: // multiple select
            $('li.answer-select').click(function (e) {
                $(this).toggleClass('selected');
                if (!$(e.target).is('input[type="checkbox"]')) {
                    var $checkbox = $(this).find('input[type="checkbox"]');
                    $checkbox.prop('checked', !$checkbox.prop('checked'));
                }
            })
            break;
    }
})

function selectOnlyThis(id) {
    if (document.getElementById(id).checked) {
        for (var i = 1; i <= 4; i++) {
            document.getElementById('answer' + i).checked = false;
        }
        document.getElementById(id).checked = true;
    }
}

function check() {
    for (var i = 1; i <= 4; i++) {
        if (document.getElementById('answer' + i).checked == true) {
            console.log('checked' + i)
        } else {
            console.log('not checked' + i)
        }
    }

}

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
})

//submit the answer
function submitAnswers() {
    var form = document.getElementById('answerForm');
    form.submit();
}