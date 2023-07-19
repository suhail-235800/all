
    
    const checkForConsecutive = (numbers) => {
            const sortedNumbers = numbers.sort((a, b) => a - b);
            for (let i = 1; i < sortedNumbers.length; i++) {
              if (sortedNumbers[i] - sortedNumbers[i - 1] !== 1) {
                return false;
              }
            }
            return true;
    }
    
    const readInput=()=> {
        const input = prompt("Enter numbers separated by comma:");
        inputValidator(input);
      }
    const inputValidator =(input)=> {
        const numbers = input.trim().split(",");
        for (let i = 0; i < numbers.length; i++) {
          if (isNaN(numbers[i])) {
            console.log("Invalid input! Please enter valid numbers separated by comma.");
            return;
          }
          const isConsecutive = checkForConsecutive(numbers);
          if (isConsecutive) {
            outputPrinter("Given numbers are Consecutive");
          } else {
            outputPrinter("Given numbers are not Consecutive");
          }
        
        readInput();
        }
    }

 
  