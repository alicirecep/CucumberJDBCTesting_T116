#Database üzerinden transport_route tablosuna yeni bir kayıt eklenebilmeli.

  Feature: Query05

    @query05
    Scenario: transport_route tablosuna yeni bir kayıt ekleme testi

      * Database baglantisi kurulur.
      * Kayit ekleme query'si hazirlanir ve calistirilir.
      * Database baglantisi kapatilir.
