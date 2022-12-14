# Özgür Yazılım Staj Projesi

Özgür Yazılım A.Ş için yaptığım Web Laboratuvar Uygulaması.

## Kurulum ve Çalıştırma

Aşağıdaki kod ile projeyi kendi kişisel bilgisayarınıza klonlayabilirsiniz.

```
git clone https://github.com/derinaden/LabWebApplication.git
```

Klonladıktan sonra terminalden projenizin olduğu konuma giderek 
``
mvn spring-boot:run
``
kodunu çalıştırarak projeyi uçurabilirsiniz.

! Proje Java 18 ile yazılmıştır. Dikkat edilmesi gereken nokta terminalde ``java -version`` yazdığınızda çıkan versiyon ile pom.xml'de yazan versiyonun birbiri ile aynı olmasıdır. Versiyonlar aynı olduğunda yukarıda belirtilen kod parçacığını yazarak projeyi çalıştırabilirsiniz.

Proje 8081 portunda çalıştığı için projeyi 
``localhost:8081/login``
veya
``localhost:8081/``
sitesini ziyaret ederek çalıştırabilirsiniz.

## Uygulama Görüntüleri

``Giriş Sayfası``

Giriş bilgileri aşağıda belirtilmiştir;

Admin için kullanıcı adı ve şifre:
``Kullanıcı Adı: admin Şifre: admin``

Laborant için kullanıcı adı ve şifre:
``Kullanıcı Adı: laborant Şifre: laborant``

![image](https://user-images.githubusercontent.com/57384157/190938923-b0cde30f-4bde-4662-82ed-aaf917a77ad6.png)

``Ana Menü``

![image](https://user-images.githubusercontent.com/57384157/190939491-400fec59-aad1-4536-b128-d6d668703f7b.png)

``Raporlar Ana Sayfası ve Hakkımda Kısmı``

![image](https://user-images.githubusercontent.com/57384157/190939710-1dfc5442-8e3f-44e9-b4bc-890e098dd694.png)

![image](https://user-images.githubusercontent.com/57384157/190939833-6b401b74-7e6b-4ce9-b014-88417633afee.png)

``Rapor Ekleme Sayfası``

![image](https://user-images.githubusercontent.com/57384157/190940702-cc425ce8-e976-44c4-81f8-81714e58dc4f.png)

``Laborant Ana Sayfası``

![image](https://user-images.githubusercontent.com/57384157/190940160-26b60308-812a-439c-89ef-daf2868fd4ee.png)

``Laborant Ekleme Sayfası``

![image](https://user-images.githubusercontent.com/57384157/190940923-1a9dbfa6-159e-4c40-9427-23b7cb63e1ac.png)

``Laborant Tablo Sayfası``

![image](https://user-images.githubusercontent.com/57384157/190940475-a3d7f957-7294-4129-84b8-9816aa876713.png)

``Raporlar Tablo Sayfası``

![image](https://user-images.githubusercontent.com/57384157/190940790-63b43fa9-6fe2-406d-af57-72cf44559e5e.png)

``Genel Testler``

![image](https://user-images.githubusercontent.com/57384157/191248521-e7a67494-82d3-4094-acc8-4a89c5f587e8.png)


## Proje İçeriği
Bu proje Spring, Spring Security, H2, Thymeleaf, Bootstrap, Mockito, Maven, Css ve Js ile yapılmıştır. Proje içinde görüntü açısından daha iyi olması için kişisel CSS dosyaları ve slide için JS dosyaları da bulunmaktadır.  

## Geliştirme
Spring taraflı daha fazla endpoint ekleyerek proje geliştirilebilir.

``
Örn:
/hastaneler/laborantlar
/laborantlar/raporlar
``

## Lisans
Bu proje [FBİ](https://github.com/derinaden) tarafından yapılmıştır.
