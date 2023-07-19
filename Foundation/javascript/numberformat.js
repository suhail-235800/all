function formatNumber(number) {
    const dollars = parseInt(number);
    const cents = parseInt((number - dollars) * 100);
    let dollarsStr = dollars.toString();
    let formattedDollars = "";
    for (let i = 0; i < dollarsStr.length; i++) {
        if ((dollarsStr.length - i) % 3 === 0 && i !== 0) {
          formattedDollars += ',';
        }
        formattedDollars += dollarsStr[i];
      }
    
    console.log("$" + formattedDollars + "." + cents);
}
    formatNumber(1234567.89);

    