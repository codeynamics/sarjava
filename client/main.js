$.ajax({
  url: "/server/sarahForm/", 
  type: "get",
  success: function (data) {
    alert(data);
    document.getElementById("text").innerHTML = "Here is the Email" + data;
  },
  error:function(error){
    alert(error);
  }
});
var values = document.getElementById("fname").value;
console.log(values);
