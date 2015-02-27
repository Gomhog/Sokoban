**Aihe:** Sokoban

Toteutetaan peli, jossa pelaaja yrittää ratkoa kenttiä. Kentät koostuvat seinistä, kytkimistä, palikoista ja uloskäynnistä. Pelaajan tehtävä on työntää palikoita niin, että kaikkien kytkimien päällä on palikka ja pelaaja pääsee uloskäynnille.

Kentät tallennetaan erillisiin tiedostoihin. Helpolla syntaksilla kartan luominen onnistuu helposti, ja level-editorin luominen tulevaisuudessa ei tuota ongelmia.

**Käyttäjä:** Pelaaja

**Pelaajan toiminnot:**

* uuden pelin aloittaminen
  * vaatii kelvollisen karttatiedoston
  * onnistuu, jos peli ei ole jo käynnissä
* pelin aloittaminen alusta
* pelin lopetus

* liikkuminen
  * onnistuu, jos kyseinen ruutu on vapaa (palikka tai seinä)
* palikan työntäminen
  * onnistuu, jos palikan takana oleva ruutu on vapaa
* kentän voittaminen
  * pelaaja liikkuu maaliin, kun kaikkien kytkimien päällä on palikka

**Rakennekuvaus**

* Pakkauksessa logiikka on pelin pelaamiseen tarvittavat luokat
  * luokka Liikkuvuus sisältää tiedot pelaajien ja palikoiden pääsyistä ruutuihin (eli seinistä)
  * luokka MaaObjektit sisältää liikkumattomien kohteiden, eli uloskäynnin ja kytkimien, sijainnit
  * luokka Palikat sisältää palikoiden sijainnit ja metodin niiden liikuttamiseen
  * luokassa Kartta tapahtuu varsinainen peli: se sisältää ilmentymän muista pakkauksen luokista ja suorittaa niiden avulla esimerkiksi pelaajan liikuttamisen
  * Suunta on listaus neljästä mahdollisesta liikkumissuunnasta
* Pakkauksessa tiedostoluku on luokat lvl-tiedostojen listaamiselle ja lukemiselle
  * TiedostoLukijan luokkakohtainen metodi luo kartan tiedostosta
  * KarttaListaajan luokkakohtainen metodi tuottaa listan tiedostopolussa olevista kartoista
* Pakkaus kayttoliittyma sisaltaa luokat graafiselle käyttöliittymälle, kuuntelijat ja piirtoluokat

**Myöhempiin julkaisuihin voi tulla lisää pulmaelementtejä**

* jää
  * jäälle työnnetty palikka jatkaa matkaa, jos mahdollista
* kuoppa
  * vapaa palikalle, mutta ei pelaajalle 
  * matala kuoppa, joka muuttuu lattiaksi, kun sinne työntää palikan?
* koroke
  * vapaa pelaajalle, ei palikalle
* heikko lattia
  * muuttuu kuopaksi, kun pelaaja kävelee yli
* näitä on paljon