**Aihe:** Sokoban

Toteutetaan peli, jossa pelaaja yritt�� ratkoa kentti�. Kent�t koostuvat seinist�, kytkimist�, palikoista ja ulosk�ynnist�. Pelaajan teht�v� on ty�nt�� palikoita niin, ett� kaikkien kytkimien p��ll� on palikka ja pelaaja p��see ulosk�ynnille.

Kent�t tallennetaan erillisiin tiedostoihin. Helpolla syntaksilla kartan luominen onnistuu helposti, ja level-editorin luominen tulevaisuudessa ei tuota ongelmia.

**K�ytt�j�:** Pelaaja

**Pelaajan toiminnot:**

* uuden pelin aloittaminen
  * vaatii kelvollisen karttatiedoston
  * onnistuu, jos peli ei ole jo k�ynniss�
* pelin aloittaminen alusta
* pelin lopetus

* liikkuminen
  * onnistuu, jos kyseinen ruutu on vapaa (palikka tai sein�)
* palikan ty�nt�minen
  * onnistuu, jos palikan takana oleva ruutu on vapaa
* kent�n voittaminen
  * pelaaja liikkuu maaliin, kun kaikkien kytkimien p��ll� on palikka

**Rakennekuvaus**

* Pakkauksessa logiikka on pelin pelaamiseen tarvittavat luokat
  * luokka Liikkuvuus sis�lt�� tiedot pelaajien ja palikoiden p��syist� ruutuihin (eli seinist�)
  * luokka MaaObjektit sis�lt�� liikkumattomien kohteiden, eli ulosk�ynnin ja kytkimien, sijainnit
  * luokka Palikat sis�lt�� palikoiden sijainnit ja metodin niiden liikuttamiseen
  * luokassa Kartta tapahtuu varsinainen peli: se sis�lt�� ilmentym�n muista pakkauksen luokista ja suorittaa niiden avulla esimerkiksi pelaajan liikuttamisen
  * Suunta on listaus nelj�st� mahdollisesta liikkumissuunnasta
* Pakkauksessa tiedostoluku on luokat lvl-tiedostojen listaamiselle ja lukemiselle
  * TiedostoLukijan luokkakohtainen metodi luo kartan tiedostosta
  * KarttaListaajan luokkakohtainen metodi tuottaa listan tiedostopolussa olevista kartoista
* Pakkaus kayttoliittyma sisaltaa luokat graafiselle k�ytt�liittym�lle, kuuntelijat ja piirtoluokat

**My�hempiin julkaisuihin voi tulla lis�� pulmaelementtej�**

* j��
  * j��lle ty�nnetty palikka jatkaa matkaa, jos mahdollista
* kuoppa
  * vapaa palikalle, mutta ei pelaajalle 
  * matala kuoppa, joka muuttuu lattiaksi, kun sinne ty�nt�� palikan?
* koroke
  * vapaa pelaajalle, ei palikalle
* heikko lattia
  * muuttuu kuopaksi, kun pelaaja k�velee yli
* n�it� on paljon