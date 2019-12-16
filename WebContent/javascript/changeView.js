function change(idName) {
  if(document.getElementById(idName).style.display=='none') {
    document.getElementById(idName).style.display = 'block';
  } else {
    document.getElementById(idName).style.display = 'none';
  }
  return false;
}

function change2(idName) {
  if(document.getElementById(idName).style.display=='block') {
    document.getElementById(idName).style.display = 'none';
  } else {
    document.getElementById(idName).style.display = 'none';
  }
  return false;
}
