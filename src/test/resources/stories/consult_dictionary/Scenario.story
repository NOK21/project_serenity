Scenario: Checking that recently added coaches are present on page 'Наша команда' and courses on their personal page
Given the user is on the SkillsUp home page
When the user click on 'Наша команда'
Then he should see the coach '<coach_name>'
When the user click on coach '<coach_name>'
Then he should see personal coach page with course '<course>'
Examples:
|coach_name|course|
|Артем Карпов|Автоматизация тестирования ПО|
|Михаил Чокан|Руководитель учебного курса в компании SkillsUp|
|Александр Кузьменко|Diving into IT|

Scenario: Checking of coach searching on SkillsUp site
Given the user is on the SkillsUp home page
When the user put keyword 'Alexander' into search field
Then he should see results that contain coach name 'Alexander Galkovskiy' and his position 'Java Tech Leader'

Scenario: Checking of searching students and their certificates on SkillsUp site
Given the user is on the SkillsUp home page
When the user put keyword '<keyword>' into search field
Then he should see results that contain certificate number '<number>' and student's name '<student_name>'
Examples:
|keyword|number|student_name|
|Alexander|06109150|Alexander Tsariov|
|Shcherbynok|11012130|Dmytro Shcherbynok|

Scenario: Checking trainings page and getting detailed information about training
Given the user is on the SkillsUp home page
When the user select training 'Путь лидера' from Education submenu
Then he will see page with detailed information as price 'Цена: 4500 грн' and group size 'Размер группы: 12-16 человек'

