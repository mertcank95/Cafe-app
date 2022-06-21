/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODEL;

/**
 *
 * @author Uğurcann
 */
public class UrunModel {
    public int urunId;
    public int kategoriId;
    public String urunAdi;
    public float urunBirimFiyati;
    public String miktarTipi;
    public String toString() {
        return this.urunAdi;
    }
}

