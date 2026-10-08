# Kafe Sipariş & Adisyon Otomasyon Sistemi

Java Swing ve MariaDB (HeidiSQL) kullanılarak geliştirilmiş, masa sipariş akışını ve adisyon yönetimini sağlayan masaüstü otomasyon yazılımı.

## 📌 Özellikler
- **Masa Yönetimi:** 20 masalık salon ızgara düzeni üzerinden anlık masa durumu takibi ve masa bazlı sipariş ekranı.
- **Kategori Bazlı Menü:** İçecekler, Tatlılar, Kahvaltılıklar gibi kategorilere göre dinamik ürün listeleme ve siparişe hızlı ürün aktarımı.
- **Dinamik Fiyatlandırma:** Eklenen ürün ve adetlere göre adisyon tutarını anlık hesaplayan fiyatlama yapısı.
- **Adisyon ve Ödeme:** Masaya ait siparişleri onaylama, ürün çıkarma ve ödeme işlemiyle birlikte hesap kapatma akışı.
- **Admin Yönetim Paneli (CRUD):** Menüye yeni ürün ekleme, fiyat güncelleme, ürün silme ve gün sonu takibi.

## 🛠 Kullanılan Teknolojiler
- **Programlama Dili:** Java
- **Kullanıcı Arayüzü (GUI):** Java Swing
- **Veritabanı:** MariaDB (Veritabanı Yönetim Aracı: HeidiSQL)
- **Veritabanı Entegrasyonu:** JDBC (Java Database Connectivity)

## ⚙️ Kurulum ve Çalıştırma
1. Yerel veritabanı sunucunuzda (localhost:3306) `kafe_db` adında bir veritabanı oluşturun.
2. `Veri.java` sınıfındaki veritabanı bağlantı adresi, kullanıcı adı ve şifre bilgilerini yerel ortamınıza göre kontrol edin.
3. Projeyi bir Java IDE'si üzerinden çalıştırarak `Login.java` üzerinden giriş yapın.
