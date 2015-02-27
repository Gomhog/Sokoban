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