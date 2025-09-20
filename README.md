# Homework: Media Playlist Manager 🎶🎬

## Завдання

Вам потрібно реалізувати систему для керування медіа-плейлистами (музика та відео).  
В системі є:

- **Музичний плейлист** (на основі файлу `data/tracks.txt`)
- **Відео плейлист** (на основі файлу `data/videos.txt`)

Ваша мета — зчитати дані з файлів, зберегти їх у generic-плейлисти та виконати обробку за допомогою **Stream API, generics, functional interfaces та method references**.

---

## 📂 Структура проєкту

```
TEMPLATE_HW11_MEDIA_PROCESSING
│
├── data
│   ├── tracks.txt         # список треків
│   └── videos.txt         # список відео
│
├── src
│   └── main
│       └── java
│           └── com
│               └── example
│                   └── media
│                       ├── app
│                       │   └── MediaProcessor.java          # головний клас із main()
│                       │
│                       ├── classes
│                       │   ├── Media.java                   # абстрактний базовий клас
│                       │   ├── Track.java                   # клас треку
│                       │   ├── Video.java                   # клас відео
│                       │   ├── Playlist.java                # generic-плейлист
│                       │   └── MediaFilter.java             # функціональний інтерфейс
│                       │
│                       └── util
│                           ├── FileUtil.java                # зчитування файлів
│                           └── MediaStatisticsWriter.java   # запис статистики
│
└── README.md
```

---

## 📂 Очікувані вихідні файли

Після виконання програми у вашій папці мають з’явитися такі файли:

1. `tracks_output.txt`
2. `videos_output.txt`

---

## 📄 Формат вихідних файлів

### Приклад `tracks_output.txt`
```
Tracks count: 20
Average duration: 276 seconds

Top 3 tracks by rating:
1. Smells Like Teen Spirit (rating 10)
2. Bohemian Rhapsody (rating 10)
3. Billie Jean (rating 10)

Pop tracks:
- Shape of You
- Billie Jean
- Rolling in the Deep
- Halo
- Uptown Funk
- Poker Face
```

### Приклад `videos_output.txt`
```
Videos count: 20
Average duration: 558 seconds

Top 3 videos by views:
1. Funny Cats Compilation (1000000 views)
2. Funny Dogs Compilation (900000 views)
3. World Cup Moments (880000 views)

Education videos:
- Top 10 Java Tips
- Java Streams Explained
- History of Rock Music
- Top 5 Space Discoveries
- Machine Learning Basics
- Physics Explained
- AI in Everyday Life
```

---

## 🛠 Що потрібно реалізувати

1. **Клас `Media` (abstract)**
    - базовий клас для всіх медіа
    - спільні поля: `title`, `duration`
    - метод `getDurationInMinutes()` (повертає у форматі `X min Y sec`)

2. **Клас `Track` extends `Media`**
    - додаткові поля: `artist`, `genre`, `rating`

3. **Клас `Video` extends `Media`**
    - додаткові поля: `channel`, `category`, `views`

4. **Generic-клас `Playlist<T extends Media>`**
    - зберігає список об’єктів
    - метод `add(T item)`
    - метод `getItems()`
    - метод `getTotalDuration()` (загальна тривалість)
    - метод `printAll()` (вивести у консоль)

5. **Функціональний інтерфейс `MediaFilter<T extends Media>`**
    - один метод `boolean test(T item)`
    - використовується для фільтрації треків та відео

6. **Клас `FileUtil`**
    - метод `readTracks(String filename)` → читає файл і повертає список `Track`
    - метод `readVideos(String filename)` → читає файл і повертає список `Video`

7. **Клас `MediaStatisticsWriter`**
    - метод `writeTrackStats(...)` → записує статистику про треки у файл `tracks_output.txt`
    - метод `writeVideoStats(...)` → записує статистику про відео у файл `videos_output.txt`

---

## ✅ Чекліст

- [ ] Доповнити клас `Media` (реалізувати спільні методи, наприклад `getDurationInMinutes()`)
- [ ] Доповнити класи `Track` та `Video` (додати специфічні поля та методи)
- [ ] Доповнити generic-клас `Playlist<T extends Media>` (методи для роботи зі списком медіа)
- [ ] Реалізувати функціональний інтерфейс `MediaFilter<T extends Media>`
- [ ] Реалізувати методи у `FileUtil` для зчитування `tracks.txt` і `videos.txt`
- [ ] Використати `Stream API` для:
    - фільтрації
    - сортування
    - підрахунку середнього
    - знаходження топ-3
- [ ] Використати лямбди та method references у реалізації
- [ ] Реалізувати методи у `MediaStatisticsWriter` для запису результатів у `tracks_output.txt` і `videos_output.txt`
- [ ] Перевірити, що програма компілюється і генерує обидва вихідні файли

---

## 🚀 Як працювати

- У вас вже є клас `MediaProcessor` із викликами методів.
- Спочатку він **не компілюється**, бо відсутні класи.
- Ваше завдання — **дописати всі потрібні класи й методи**.
- Коли структура буде правильною, програма скомпілюється і згенерує вихідні файли.
