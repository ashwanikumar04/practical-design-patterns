var fs = require("fs");
var array = JSON.parse(fs.readFileSync('data.json'));

var generated = [];
var text =
    "class: center, middle \n\n# Practical Design Patterns\n##### Use *left-right arrow* for navigation or press *h* for more options.\n\n";
generated.push(text);

for (var index = 0; index < array.length; index++) {
    text =
        "# " + "\n\n" +
        "<img src='http://git.ashwanik.in/practical-design-patterns/images/" + array[index].img + ".svg' " +
        "alt='" + array[index].name + "' class='" + array[index].imgClass + "'/>\n\n" +
        "<div class='a-center'> For implementation, see <a href='https://github.com/ashwanikumar04/practical-design-patterns/tree/master/src/main/java/in/ashwanik/pdp/" + array[index].type + "/" +
        array[index].code + "' target='_blank'>here</a>​​​​​​​​​​​​​​​​​​​​​​​​​​​​​​​​​​​​</div>" +
        "\n\n";
    generated.push(text);
}
var complete = generated.join("---\n\n");

fs.writeFile("../docs/presentation.md", complete, function (err) {
    if (err) {
        return console.log(err);
    }
    console.log("The file was saved!");
});