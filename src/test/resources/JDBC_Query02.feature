#Database üzerinden class_sections tablosundaki datalar arasından
# class_id ve section_id verisi birbirine eşit olan içeriklerin
# id'lerini listeleyiniz


  Feature: Query02

    @query02
    Scenario: class_sections tablosundan class_id ve section_id verisi birbirine eşit olan içeriklerin testi

      * Database baglantisi kurulur.
      * class_sections tablosu testi icin query hazirlanir.
      * class_sections tablosu testi sonuclari dogrulanir.
      * Database baglantisi kapatilir.

