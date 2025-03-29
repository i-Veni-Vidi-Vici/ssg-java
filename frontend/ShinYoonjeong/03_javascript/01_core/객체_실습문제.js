const calculator = {
    a : 10,
    b : 20,
    sum : function(){
        console.log(this.a+this.b);
        
    },
    multi : function(){
        console.log(this.a*this.b);
        }
}
calculator.sum()
calculator.multi()


function Calculator () {
    this.a = 10;
    this.b = 20;
    function sum(){
        console.log(a+b);
    }
    function multi(){
        console.log(a*b);
    }

}
