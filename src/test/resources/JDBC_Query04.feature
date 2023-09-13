# Database üzerinden topic tablosundaki istenen id'nin
# name bilgisi update edilebilmeli.


  Feature: Query04
    @query04
    Scenario: topic tablosundan name bilgisi update testi

      * Database baglantisi kurulur.
      * Update query'si hazirlanip calistirilir
      * Update isleminin yapildigi dogrulanir
      * Database baglantisi kapatilir.