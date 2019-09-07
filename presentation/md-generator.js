var fs = require("fs");
var array = [{
        "img": "cor",
        "name": "Chain of responsibility",
        "code": "cor",
        "imgClass": "img-center-50"
    },
    {
        "img": "pub_sub",
        "name": "Publisher Subscriber",
        "code": "pub_sub",
        "imgClass": "img-center-80"
    },
    {
        "img": "observer",
        "name": "Observer",
        "code": "observer",
        "imgClass": "img-center-80"
    },
    {
        "img": "builder",
        "name": "Builder",
        "code": "builder",
        "imgClass": "img-center-70"
    },
    {
        "img": "iterator",
        "name": "Iterator",
        "code": "iterator",
        "imgClass": "img-center-50"
    },
    {
        "img": "decorator",
        "name": "Decorator",
        "code": "decorator",
        "imgClass": "img-center-50"
    }
];

var generated = [];
var text =
    "class: center, middle \n\n# Practical Design Patterns\n##### *Use left-right arrow for navigation*\n\n";
generated.push(text);

for (var index = 0; index < array.length; index++) {
    text =
        "# " + "\n\n" +
        "<img src='http://git.ashwanik.in/practical-design-patterns/images/" + array[index].img + ".png' " +
        "alt='" + array[index].name + "' class='" + array[index].imgClass + "'/>\n\n" +
        "<div class='a-center'> For implementation, see <a href='https://github.com/ashwanikumar04/practical-design-patterns/tree/master/src/main/java/in/ashwanik/pdp/" +
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