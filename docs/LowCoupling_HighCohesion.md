## Завдання 5. Метричний аналіз та інженерна верифікація (Low Coupling + High Cohesion)

Для оцінювання результатів рефакторингу використано метрики CBO (Coupling Between Objects) і LCOM4 (Lack of Cohesion of Methods). Під час підрахунку CBO враховувалися лише залежності між класами проєкту, а примітивні типи та стандартні бібліотечні класи (`java.lang.*`, `Scanner`) не враховувалися. Для LCOM4 не враховувалися конструктори та прості getter-методи. 

### Підсумкова порівняльна таблиця метрик

| Клас | CBO до | CBO після | LCOM4 після |
|---|---|---|---|
| `LegacyRentalManager` | 3 | видалено | — |
| `Client` | 0 | 0 | 1 |
| `Vehicle` | 0 | 2 | 1 |
| `RentalAgreement` | 2 | 4 | 1 |
| `RentalAgreementFactory` | — | 4 | 1 |
| `RentalCostPolicyFactory` | — | 4 | 1 |
| `InsurancePolicyFactory` | — | 3 | 1 |
| `RentalConsoleUI` | — | 3 | 1 |
| `RentalController` | — | 4 | 1 |
| `RentalWorkflow` | — | 4 | 1 |
| `RentalRegistrationService` | — | 4 | 1 |
| `RentalCompletionService` | — | 3 | 1 |
| `ConsoleRentalRepository` | — | 2 | 1 |
| `SmsNotificationService` | — | 1 | 1 |
| `EconomyRentalCost` | — | 1 | 1 |
| `BusinessRentalCost` | — | 1 | 1 |
| `SuvRentalCost` | — | 1 | 1 |
| `BasicInsuranceTotal` | — | 1 | 1 |
| `FullInsuranceTotal` | — | 1 | 1 |
| `RentalRequest` | — | 0 | — |
| `RentalResponse` | — | 1 | — |
| `RentalUseCase` | — | 2 | — |
| `RentalCostPolicy` | — | 0 | — |
| `InsuranceTotalPolicy` | — | 0 | — |
| `RentalRepository` | — | 1 | — |
| `NotificationService` | — | 0 | — |

Примітка: «—» означає, що клас не існував до рефакторингу або що LCOM4 для нього не оцінюється (DTO та інтерфейси не мають реалізації методів).

### Інженерні висновки

**1. Зменшення концентрації відповідальностей.** У початковій реалізації `LegacyRentalManager.processRentalConsole()` одночасно виконував введення даних, створення об'єктів, розрахунок вартості, страховки та застави, формування ваучера, збереження та надсилання SMS. Після рефакторингу ці обов'язки розподілено між `RentalConsoleUI`, `RentalController`, `RentalWorkflow`, `RentalRegistrationService`, `RentalCompletionService`, доменними сутностями та фабриками. Це полегшує тестування, супровід і дозволяє змінювати окремі частини системи без впливу на інші.

**2. Аналіз CBO (Low Coupling).** Усі класи системи мають CBO ≤ 4, тобто цільове значення досягнуто. Показник `LegacyRentalManager` (CBO = 3) формально нижчий, але це не свідчить про якість: метод залежав лише від трьох класів, бо всі вони були пасивними контейнерами з публічними полями, і вся логіка була зосереджена в одному місці. Після рефакторингу CBO доменних сутностей зріс (`Vehicle` 0 → 2, `RentalAgreement` 2 → 4), бо залежності між класами стали явними й обґрунтованими: сутності залежать від стабільних інтерфейсів політик, а не від рядкових порівнянь. Класи на межі норми (`RentalAgreement`, фабрики, `RentalController`, сервіси, `RentalWorkflow`, CBO = 4) не перевищують її, але додавання нової залежності вимагатиме подальшого розділення.

**3. Аналіз LCOM4 (High Cohesion).** Для всіх оцінених класів отримано LCOM4 = 1: методи кожного класу утворюють один зв'язний компонент і працюють над єдиним станом або єдиною відповідальністю. Зокрема, у `RentalAgreement` методи `calculateRentalTotal()` та `calculateInsuranceTotal()` об'єднує `calculateFinalPrice()`, а `approve()` викликає `calculateFinalPrice()` і `calculateDepositAmount()`, тому всі методи належать до одного компонента. Цільове значення досягнуто.

**3. Інкапсуляція та напрямок залежностей.** Усі поля доменних сутностей стали `private final`, об'єкти створюються у валідному стані через статичні фабричні методи, а стан `RentalAgreement` змінюється лише через `approve()`. Залежності спрямовані від нестабільного UI до стабільного домену (`RentalConsoleUI` → `RentalUseCase` → `RentalController` → `RentalWorkflow` → сервіси → домен), а технічні деталі (збереження, SMS) підключаються через інтерфейси `RentalRepository` та `NotificationService`.

**4. Розширюваність.** Алгоритми розрахунку вартості оренди та страхування винесено за інтерфейси `RentalCostPolicy` і `InsuranceTotalPolicy` (Polymorphism, Protected Variations). Новий клас авто чи тип страховки додається новою реалізацією та одним `case` у фабриці, без змін у `Vehicle`, `RentalAgreement` та сервісах.

**5. Компроміси.** Кількість класів зросла з 4 до понад 25, ланцюжок UI → Controller → Workflow → Services додає рівнів для невеликої системи, а `RentalController` фактично лише переадресовує виклик. Коефіцієнти тарифів (1.3, 1.2, 200, 500) лишаються захардкодженими в реалізаціях політик, а перевірка класу авто частково дублюється у `Vehicle.create` та `RentalCostPolicyFactory`. Ці недоліки не порушують цільових метрик, але є напрямками подальшого вдосконалення.

**6. Загальна оцінка.** Поставлену мету досягнуто: з анемічної моделі та монолітного методу отримано Rich Domain Model із розподіленими відповідальностями за повним набором патернів GRASP. Усі класи відповідають нормам CBO ≤ 4 та LCOM4 = 1.

