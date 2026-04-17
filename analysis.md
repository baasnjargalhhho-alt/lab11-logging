# Лог шинжилгээний тайлан (Analysis Report)

### 1. ERROR мөрүүдийг шүүх
Команд: `Select-String -Path "logs/app.log" -Pattern "ERROR"`

**Гаралт:**
logs\app.log:6:2026-04-17T22:12:01,694 [main] ERROR BankAccount:34 - 
logs\app.log:7:2026-04-17T22:12:01,697 [main] FATAL BankAccount:52 - 
FATAL ERROR: System configuration file is corrupted or missing!
---

### 2. Лог түвшний статистик (Тооллого)
Команд: `Get-Content "logs/app.log" | ForEach-Object { $_.Split(' ')[2] } | Group-Object | Select-Object Count, Name`

**Гаралт:**
| Count                     | Name  |
|---------------------------|-------|
| [2026-04-17T22:12:01,656] | INFO  |
| [2026-04-17T22:12:01,689] | DEBUG |S
| [2026-04-17T22:12:01,691] | WARN  |
| [2026-04-17T22:12:01,694] | ERROR |
| [2026-04-17T22:12:01,697] | FATAL |

---

### 3. Даалгавар 4.1: tail -f vs cat
**Асуулт:** Яагаад `tail -f` (Windows-д `Get-Content -Wait`) нь `cat` эсвэл `less`-ээс debug хийхэд илүү хэрэгтэй вэ?

**Хариулт:** `tail -f` нь файлыг хаалгүйгээр нээлттэй үлдээж, шинээр нэмэгдэж буй лог мэдээллийг бодит цаг хугацаанд шууд терминал дээр харуулдаг. Программ ажиллах явцад гарч буй үйл явдлуудыг шууд хянах (real-time monitoring) боломжийг олгодог учраас алдааг (debug) барьж авахад хамгийн үр дүнтэй байдаг.