# [System obsługi siłowni](http://mygymapp-env.eba-jpprh8un.eu-central-1.elasticbeanstalk.com/)
Autorska aplikacja do zarządzania klubem fitness. Napisana i rozwijana w celach edukacyjnych.<br/>
Umieszczona na AWS i dostępna poprzez link: http://mygymapp-env.eba-jpprh8un.eu-central-1.elasticbeanstalk.com/.
***
System obsługi siłowni jest aplikacja stworzona w celu ulepszenia zarządzania klubem fitness oraz poprawy jakości obsługi klienta.<br/>
W systemie wyodrębiono pięć ról użytkowników: *Administrator*, *Manager*, *Pracownik*, *Trener* oraz *Klient*. W celach demonstracyjnych, po zarejestrowaniu się na stronie, nowy użytkownik ma przydzielone wszystkie role oprócz Administratora. W zależności od roli dostępne są poszczególne funkcjonalności: 
| Rola       | Funkcjonalności          | Stan  |
| :------------- |:-------------| :-----|
| Administrator  | Edycja, usunięcie lub zmiana roli użytkownika. Wyświetlanie/dodawanie/edycja/usuwanie trenerów, zajęć oraz sprzętu fitness | dostępne |
| Manager      | Wyświetlanie/dodawanie/edycja/usuwanie trenerów, zajęć oraz sprzętu fitness . Wyświetlanie listy użytkowników    |  dostępne  |
| Pracownik | -     |    w opracowaniu |
| Trener | Wyświeltanie listy użytkowników zapisanych na dane zajęcia. |   w opracowaniu|
| Klient | zapis na zajęcia oraz rezygnacja, podgląd zajęć użytkownika, edycja danych osobowych|   dostępne|

***
### Technologie
#### __Front-end__: 
* HTML
* CSS
* JavaScript
* framework Bootstrap
* Java Server Pages. <br/>
#### __Back-end__: 
* Java/framework Spring,  w szczególności Spring MVC, Spring Security, Spring AOP oraz Spring REST.<br/>
#### __Baza danych__: 
* MySQL 
* dostęp za pomocą frameworka Hibernate. <br/>
#### __Integracje__:
* Google reCAPTCHA
#### __Hosting__:
* Amazon Web Services