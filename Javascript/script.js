function menseki(hankei, ennshuritsu = 3.14){
    return "面積は" + hankei * hankei * ennshuritsu + "cmです。";
}
document.write(menseki(5));
document.write("<br>");
document.write(menseki(7));
document.write("<br>");
document.write(menseki(10));
document.write("<br>");


document.write("<br>");
document.write("<br>");

function totalPrice(otonaNum, kodomoNum){
    var total = otonaNum * 500 + kodomoNum * 200
    return "グループの合計金額は"　+ total + "円です。";
}
document.write(totalPrice(2,4) + "<br>");
document.write(totalPrice(1, 5) + "<br>");
document.write(totalPrice(3, 7) + "<br>");

















