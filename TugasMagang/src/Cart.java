import java.util.HashMap;

public class Cart {
	private HashMap<String, Integer> cart = new HashMap<String, Integer>(); 
	
	void tambahProduk(String kodeProduk, int kuantitas) {
		if(cart.containsKey(kodeProduk)) {
			cart.put(kodeProduk, kuantitas+cart.get(kodeProduk));
		}else {
			cart.put(kodeProduk, kuantitas);
		}
		
	}
	
	void hapusProduk(String kodeProduk) {
		cart.remove(kodeProduk);
	}
	
	void tampilkanCart() {
		for(String key : cart.keySet()) {
			System.out.println(key + ' '+ '(' + cart.get(key) + ')');
		}
	}
	
	public static void main (String[] args) {
		Cart keranjang = new Cart();

		keranjang.tambahProduk("Pisang Hijau", 2);

		keranjang.tambahProduk("Semangka Kuning", 3);

		keranjang.tambahProduk("Apel Merah", 1);
		keranjang.tambahProduk("Apel Merah", 4);
		keranjang.tambahProduk("Apel Merah", 2);

		keranjang.hapusProduk("Semangka Kuning");

		keranjang.hapusProduk("Semangka Merah");

		keranjang.tampilkanCart();
	}
}
