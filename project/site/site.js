(function () {
    var callback = function (data) {
        for (var i = 0; i < data.tree.length; i++) {
            var tree = data.tree[i];
            if (tree.type === "tree") {
                var path = tree.path;
                $("#scaladoc").append("<a class='list-group-item' target='_blank' href='" + path + "/index.html'>" + path + "</a>")
            }
        }
    };
    $.get("https://api.github.com/repos/reactivecodes/scala-time/git/trees/gh-pages", {}, callback)
})();
