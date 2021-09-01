Feature: Add specifications of product in terminal

@Run
  Scenario: Add specifications of product in terminal
    Given user is at 'https://roofart.md/' page
    And user click on menu button
    And user select 'Țiglă metalică clasică' item
    When user select 'Țiglă metalică Arctica Clasică' product from list
    Then next specifications are displayed
    |specificationTitle        |    specification   |
    |Adâncime val              |    22 mm           |
    |Lungime modul             |    350 mm          |
    |Lăţime totală             |    1205 mm         |
    |Lăţime utilă de acoperire |    1130 mm         |
    |Lungime maximă            |    6000 mm         |
    |Lungime minimă            |    460 mm          |
    |Înclinaţie minimă         |    14°             |
    |Greutate pe suprafață     |    ≈ 5 kg/m2       |