$(function(){
    $("#listcontainer").jqGrid({
        url:'${showBookUrl}/listgrid',
        datatype: 'json',
        mtype: 'GET',
        colNames:['${labelBookTitle}','${labelBookISBN}','${labelBookPrice}','${labelBookPublisher}','${labelBookCategory}'],
        colModel :[
            {name:'title', index:'title', width:250},
            {name:'isbn', index:'isbn', width:100},
            {name:'price', index:'price', width:50},
            {name:'publisher', index:'publisher', width:150},
            {name:'category_name', index:'category_name', width:100}
        ],
        jsonReader : {
            root:"bookData",
            page: "currentPage",
            total: "totalPages",
            records: "totalRecords",
            repeatitems: false,
            id: "id"
        },
        pager: '#pager',
        rowNum:10,
        rowList:[10,20,30],
        sortname: 'title',
        sortorder: 'asc',
        viewrecords: true,
        gridview: true,
        height: 450,
        width: 700,
        caption: '${labelBookList}',
        onSelectRow: function(id){
            document.location.href ="${showBookUrl}/" + id;
        }
    });
});