(function($) {
    $(function() {
        $.widget("zpd.paging", {
            options: {
                limit: 5,
                rowDisplayStyle: 'block',
                activePage: 0,
                rows: []
            },
            _create: function() {
                var rows = $("tbody", this.element).children();
                this.options.rows = rows;
                this.options.rowDisplayStyle = rows.css('display');
                var nav = this._getNavBar();
                this.element.after(nav);
                this.showPage(0);
            },
            _getNavBar: function() {
                var rows = this.options.rows;
                var nav = $('<div>', {class: 'paging-nav'});
                for (var i = 0; i < Math.ceil(rows.length / this.options.limit); i++) {
                    this._on($('<a>', {
                        href: '#',
                        text: (i + 1),
                        "data-page": (i)
                    }).appendTo(nav),
                            {click: "pageClickHandler"});
                }
                //create previous link
                this._on($('<a>', {
                    href: '#',
                    text: '<<',
                    "data-direction": -1
                }).prependTo(nav),
                        {click: "pageStepHandler"});
                //create next link
                this._on($('<a>', {
                    href: '#',
                    text: '>>',
                    "data-direction": +1
                }).appendTo(nav),
                        {click: "pageStepHandler"});
                return nav;
            },
            showPage: function(pageNum) {
                var num = pageNum * 1; //it has to be numeric
                this.options.activePage = num;
                var rows = this.options.rows;
                var limit = this.options.limit;
                for (var i = 0; i < rows.length; i++) {
                    if (i >= limit * num && i < limit * (num + 1)) {
                        $(rows[i]).css('display', this.options.rowDisplayStyle);
                    } else {
                        $(rows[i]).css('display', 'none');
                    }
                }
            },
            pageClickHandler: function(event) {
                event.preventDefault();
                $(event.target).siblings().attr('class', "");
                $(event.target).attr('class', "selected-page");
                var pageNum = $(event.target).attr('data-page');
                this.showPage(pageNum);
            },
            pageStepHandler: function(event) {
                event.preventDefault();
                //get the direction and ensure it's numeric
                var dir = $(event.target).attr('data-direction') * 1;
                var pageNum = this.options.activePage + dir;
                //if we're in limit, trigger the requested pages link
                if (pageNum >= 0 && pageNum < this.options.rows.length) {
                    $("a[data-page=" + pageNum + "]", $(event.target).parent()).click();
                }
            }
        });
    });
})(jQuery);

let place = document.getElementById('r');
function display(data){
    var key = Object.keys(data).sort(
        function order(key1,key2){
            if(data[key1][1]< data[key2][1]) return 1;
            else return -1;
        }
    )
    var temp={}
    for (var i = 0; i < key.length; i++) {
        temp[key[i]] = data[key[i]];
        delete data[key[i]];
    } 

    for (var i = 0; i < key.length; i++) {
        data[key[i]] = temp[key[i]];
    } 
    var i=1;
   for (const [key,value] of Object.entries(data)){
      let row = document.createElement('tr')
      let id = document.createElement('td');
      let name = document.createElement('td');
      let score = document.createElement('td');
      let num = document.createElement('td');
      id.textContent = i;
    name.textContent = value[0];
    score.textContent = value[1];
    num.textContent = 2-value[2]
    row.appendChild(id)
    row.appendChild(name)
    row.appendChild(score)
    row.appendChild(num)
    place.appendChild(row)
    i++;
   }
}

function show(){
    
    let url = "http://127.0.0.1:5000/v1/values"
    let options={
        method:"GET"
    }
    fetch(url,options)
    .then(function (response){
        return response.json();
    }).then(function (text){
        let {body} = text 
        display(body)
    })


}



