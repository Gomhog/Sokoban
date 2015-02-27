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