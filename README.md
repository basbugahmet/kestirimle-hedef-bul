# Kestirimle Hedef Bul

**Projenin Amacı:** Bu projenin amacı, belirli bir alan içerisinde iki sensör yardımıyla, hedefin konumunu tespit eden bir sistem geliştirmektir.

Bu proje, 1000x1000 boyutlarındaki bir alanda herhangi bir yerde konumlanabilen iki sensör ve bir hedef içermektedir. Sensörler, hedefin kerterizini belirleyerek bu bilgiyi TCP/IP protokolü aracılığıyla işleyici birime iletmektedir. İşleyici birim, sensörlerden gelen verileri kullanarak hedefin kesin Kartezyen koordinatlarını hesaplamaktadır. Proje Java programla dili ile geliştirilmiştir.

Bu projenin geliştirilmesi ile aşağıdaki hedeflere ulaşılması amaçlanmaktadır:

-   Sensör verileri kullanarak bir hedefin konumunu yüksek doğrulukla tespit edebilme.
    
-   Dağıtık bir sistemde veri toplama ve işleme süreçlerinin entegrasyonu ve yönetimi.
    
-   TCP/IP protokolü kullanarak cihazlar arası iletişim sağlama.
    
-   SOLID prensiplerine uygunluk.

## Projenin Çalıştırılması

1.  ***applications*** paketinin içinde yer alan **‘ProcessorApplication’** uygulaması çalıştırılır.
    
2.  ***applications*** paketinin içinde yer alan **‘SensorApplication’** uygulaması çalıştırılır.
    
3.  ***applications*** paketinin içinde yer alan **‘TargetApplication’** uygulaması çalıştırılır.
    
4.  Bu işlemler uygulandığında Processor Application konsol çıktısında tespit edilen hedefin konumu yazdırılmaktadır.

## **Paketler ve Sınıfların Açıklaması**

Bu yapı, çeşitli bileşenlerin belirli işlevleri yerine getirdiği modüler bir sistem sunar. Her paketin ve sınıfın işlevselliği aşağıda detaylandırılmıştır.

### **analyticalgeometry Paketi**

Bu paket, analitik geometri ile ilgili hesaplamalar ve veri yapıları içerir.

-   **BearingCalculator:** Kerteriz hesaplamasını yapar.
    
-   **IntersectionFinder:** İki doğrunun kesişim noktasını bulur.
    
-   **Line:** Bir doğruyu temsil eder, eğim ve y-eksenini kestiği noktayı hesaplar.
    
-   **Point:** İki boyutlu bir noktayı temsil eder.
    
-   **RandomPointGenerator:** Rastgele noktalar oluşturan bir sınıftır,
    

----------

### **applications Paketi**

Bu paket, uygulama senaryolarını içerir ve ana çalışma fonksiyonlarını sağlar.

-   **ProcessorApplication:** İşlemci ile ilgili uygulamaları temsil eder, verileri işleyerek hedef konumunu belirler.
    
-   **SensorApplication:** Hedeften veri alır ve bu verileri işleyerek kerterizi hesaplar.
    
-   **TargetApplication:** Rastgele bir hedef konumu oluşturur ve bu veriyi sensör uygulamasına gönderir.
    

----------

### **commucation Paketi**

Bu paket, veri iletişimi ile ilgili sınıfları içerir. DataReceiver adlı class abstract tanımlanmıştır. ProcessorDataReceiver ve SensorDataReceiver classları ilgili classı miras almıştır. Tek bir class tanımlayıp, bu classta şart ifadeleri kullanılarak işlemleri yapmak SOLID’e aykırı olacağı için böyle bir yaklaşım benimsenmiştir.

-   **DataReceiver:** Verileri almak için kullanılan soyut bir sınıftır.
    
-   **DataSender:** Verileri göndermek için kullanılır.
    
-   **ProcessorDataReceiver:** İşlemci verilerini almak için özelleştirilmiş bir sınıftır.
    
-   **SensorDataReceiver:** Sensör verilerini almak için özelleştirilmiş bir sınıftır.
    

----------

### **components Paketi**

Bu paket, sistemin 3 ana bileşenini içerir.

-   **Processor:** Verileri işleyen bileşendir, sensör verilerini kullanarak kesişim noktalarını hesaplar.
    
-   **Sensor:** Belirli bir konumda bulunan ve verileri toplayan sensörleri temsil eder.
    
-   **Target:** İzlenmesi gereken hedefi temsil eder.
    

  
  

----------

### **exceptions Paketi**

Bu paket, özel durumlar ve hatalar için sınıflar içerir.

-   **SensorPositionException:** Sensörlerin konumlarıyla ilgili hataları temsil eden özel bir error handling classıdır.


## **Örnek Program Çalıştırılması**

1.  ***applications*** paketinin içinde yer alan **‘ProcessorApplication’** uygulaması çalıştırılır.
    **![](https://lh7-us.googleusercontent.com/exY1UgoO7Y7VLaDmL2NO2OGNZFw_Fz3mAwX46QFcI97N1dhTm52gwdVvxtAGMYKHpbrfC9WaeciDupSNM7mdwovm6EvPgq6JvHrfInUh1ZiYH7jNYd3G2Vxy4VHXJtaTGWDsXLsenSOfy9S8r0xSzoI)**
2.  ***applications*** paketinin içinde yer alan **‘SensorApplication’** uygulaması çalıştırılır
**![](https://lh7-us.googleusercontent.com/lpohDiF2H6QQC-D25KCuqSRbs0UElh01JuyrPwREx2M59Uftelggpx4Q3Gb40mIUrQCm3mhxaJUfZ9XtDXIdKN2Dc9chu7DghgqRhwaVInxbLwPuxrbIL3ILFtqg4LfpKYH9mOJ3xilHRQ4HmcWWe1c)**
3.  ***applications*** paketinin içinde yer alan **‘TargetApplication’** uygulaması çalıştırılır.                                           
**![](https://lh7-us.googleusercontent.com/gNM7dfgLcjTBsJpNCWVJRg2d8h75TTX-JQ8LTLtGyI-DZ1e1TloUr6tS3sg8CCoge1DIkNXJystoE7Spu0EBvvadDFvQ8ztN1J_SFozaUszZYpBGTnS3mZcLHKufG4lmwbaqyhL1JhcZjT0SeWJsdQY)**
4.  SensorApplication uygulamasında Sensörlerin koordinatları ve kerteriz değeleri yazdırılır.
**![](https://lh7-us.googleusercontent.com/dbx9VH62xwwdrv1NqHAwfXF-kpeISovm1NLBo-FYLkv3A3T4mFow-8rywkg6Fty6EvAqM3ozGvYLxUzXyVUJ_0ELETxcz28g5W69JtmWE8E5O05SmBP3co7wWlx-WvkpPhyn2yensldnfM0Vo09alN0)**
5.  ProcessorApplication uygulamasında tespit edilen hedefin koordinatları yazdırılır.
**![](https://lh7-us.googleusercontent.com/mLGPbzDa6RvW85HuredjeebfePEiJfWrD37NiS6oeUOgoVn2tNt0JwxcIfmcqXLYRV0EQiKd0mKiaNGlo2KGy0Vn_FlZt2xtPjdpKxdeASG5mpYWBUFSKNueTWtUYu8tS79PKaN0t3rlYHseyZwvLJ8)**

## Class Diagram

**![](https://lh7-us.googleusercontent.com/RxsYk2tkihHTajPMOBICP8EqTfRgoIYf8cWZaax91RlcEWKmyXjzsug9YlzO2i6dsbsSeGQHKcEzdVBGIYweQqEorF0nMYm6KhM_IZgU05en3_krj7wx24J1ZkIVrmNvGbcW9zhdX6oFO4o_PjCPANw)**
