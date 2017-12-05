$(function() {
  $('a[href=#header]').click(function(){
    $('html').animate({scrollTop:0}, 'slow');
    return false;
  });
});