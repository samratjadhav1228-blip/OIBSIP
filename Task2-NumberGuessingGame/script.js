let secretNumber = Math.floor(Math.random() * 100) + 1;
let attemptsLeft = 10;

function checkGuess(){

let userGuess = Number(document.getElementById("guessInput").value);
let message = document.getElementById("message");

if(attemptsLeft <= 0){
message.innerText = "Game Over! Number was " + secretNumber;
return;
}

attemptsLeft--;
document.getElementById("attempts").innerText = attemptsLeft;

if(userGuess === secretNumber){

message.innerText = "🎉 Correct! You guessed the number!";
}

else if(userGuess > secretNumber){

message.innerText = "📉 Too High! Try again.";
}

else{

message.innerText = "📈 Too Low! Try again.";
}

}

function restartGame(){

secretNumber = Math.floor(Math.random() * 100) + 1;
attemptsLeft = 10;

document.getElementById("attempts").innerText = attemptsLeft;
document.getElementById("message").innerText = "";
document.getElementById("guessInput").value = "";

}
