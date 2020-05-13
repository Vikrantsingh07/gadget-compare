


$(function(){
//Solving the Active Menu problem

switch(menu){

   case 'About Us':
         $('#about').addClass('active');
         break;

   case 'Contact':
         $('#contact').addClass('active');
         break;

   case 'Service':
       $('#service').addClass('active');
         break;
default:
      $('#home').addClass('active');
         break; 

  }

   //Code For Jquery DataTable
   //Create A dataSet
   var $table=$('#productListTable') ;
   if($table.length){
	   console.log("Inside The table------->");
	   var jsonUrl = '';
	   console.log("window.categoryId------->",window.categoryId);
	   console.log("window.contextRoot------->",window.contextRoot);
		if (window.categoryId == '') {
			jsonUrl = window.contextRoot + '/json/data/all/products';
		} else {
			jsonUrl = window.contextRoot + '/json/data/category/'
					+ window.categoryId + '/products';
		}
	   
	   
	   $table.DataTable({
		   lengthMenu: [[3,5,10,-1],['3 Records','5 Records','10 Records','All']],
		   pageLength:5,
		   ajax:{
			 url: jsonUrl,
			 dataSrc:''
		   },
	columns:[
{
	data : 'code',
	bSortable : false,
	mRender : function(data, type, row) {

		return '<img src="' + window.contextRoot
				+ '/resources/img/' + data
				+ '.jpg" class="dataTableImg"/>';

	}
},        
     {
	    data : 'name'
     },
     {
	    data : 'brand'
     },
    {
	    data : 'unitPrice',
	    mRender : function(data, type, row) {
		         return '&#8377; ' + data
	    }
    },
    {
	    data : 'quantity',
	},
    {
		data : 'id',
		mRender : function(data, type, row) {

			var str = '';
			bSortable : false,
			str += '<a href="'
					+ window.contextRoot
					+ '/show/'
					+ data
					+ '/product" class="btn btn-primary"><span class="glyphicon glyphicon-eye-open"></span></a> &#160;';
			
			str += '<a href="'
				+ window.contextRoot
				+ '/manage/'
				+ data
				+ '/product" class="btn btn-warning"><span class="glyphicon glyphicon-pencil"></span></a>';

		    return str; 
		}
    }
   
]
	   });
   }
});