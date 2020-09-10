const lightbox=document.createElement('div')
lightbox.id='lightbox'
document.body.appendChild(lightbox)

const workouts=document.querySelectorAll('.zajecia_inner')
workouts.forEach(workout =>{
  workout.addEventListener('click', e=>{
    lightbox.classList.add('active')

    let zajeciaImgDiv=document.createElement('div')
    zajeciaImgDiv.classList.add('zajecia_img')

    let overlayDiv=document.createElement('div')
    overlayDiv.classList.add('overlayToShow')

    let workoutImage=document.createElement('img')
    workoutImage.src=workout.querySelector('img').src

    overlayDiv.appendChild(workoutImage)
    zajeciaImgDiv.appendChild(overlayDiv)

//Czas rozpoczecia
        let czasRozpoczeniaHeader=document.createElement('div')
        czasRozpoczeniaHeader.classList.add('zajecia_info_header')
        czasRozpoczeniaHeader.textContent="Czas rozpoczęcia:"

        let czasRozpoczeniaContent=document.createElement('div')
        czasRozpoczeniaContent.classList.add('zajecia_info_content')
        czasRozpoczeniaContent.textContent=workout.querySelector('form input[id=workoutStartTime]').value

        let czasRozpoczenia=document.createElement('div')
        czasRozpoczenia.classList.add('zajecia_info')
        czasRozpoczenia.appendChild(czasRozpoczeniaHeader)
        czasRozpoczenia.appendChild(czasRozpoczeniaContent)

//Czas trwania:
        let czasTrwaniaHeader=document.createElement('div')
        czasTrwaniaHeader.classList.add('zajecia_info_header')
        czasTrwaniaHeader.textContent="Czas trwania:"

        let czasTrwaniaContent=document.createElement('div')
        czasTrwaniaContent.classList.add('zajecia_info_content')
        czasTrwaniaContent.textContent=workout.querySelector('form input[id=workoutDuration]').value

        let czasTrwania=document.createElement('div')
        czasTrwania.classList.add('zajecia_info')
        czasTrwania.appendChild(czasTrwaniaHeader)
        czasTrwania.appendChild(czasTrwaniaContent)

//Trening prowadzi:
        let trenerHeader=document.createElement('div')
        trenerHeader.classList.add('zajecia_info_header')
        trenerHeader.textContent="Trening prowadzi:"

        let trenerContent=document.createElement('div')
        trenerContent.classList.add('zajecia_info_content')
        trenerContent.textContent=workout.querySelector('form input[id=trainerName]').value

        let trener=document.createElement('div')
        trener.classList.add('zajecia_info')
        trener.appendChild(trenerHeader)
        trener.appendChild(trenerContent)

//Maksymalna ilosc ludzi
        let maxPeopleHeader=document.createElement('div')
        maxPeopleHeader.classList.add('zajecia_info_header')
        maxPeopleHeader.textContent="Maksymalna ilość osób:"

        let maxPeopleContent=document.createElement('div')
        maxPeopleContent.classList.add('zajecia_info_content')
        maxPeopleContent.textContent=workout.querySelector('form input[id=maxPeople]').value

        let maxPeople=document.createElement('div')
        maxPeople.classList.add('zajecia_info')
        maxPeople.appendChild(maxPeopleHeader)
        maxPeople.appendChild(maxPeopleContent)

//Miejsce
        let placeNameHeader=document.createElement('div')
        placeNameHeader.classList.add('zajecia_info_header')
        placeNameHeader.textContent="Miejce:"

        let placeNameContent=document.createElement('div')
        placeNameContent.classList.add('zajecia_info_content')
        placeNameContent.textContent=workout.querySelector('form input[id=placeName]').value

        let placeName=document.createElement('div')
        placeName.classList.add('zajecia_info')
        placeName.appendChild(placeNameHeader)
        placeName.appendChild(placeNameContent)

//Kontener dla opisu
    let zajeciaOpisDiv=document.createElement('div')
    zajeciaOpisDiv.classList.add('zajecia_opis')
    zajeciaOpisDiv.appendChild(czasRozpoczenia)
    zajeciaOpisDiv.appendChild(czasTrwania)
    zajeciaOpisDiv.appendChild(trener)
    zajeciaOpisDiv.appendChild(maxPeople)
    zajeciaOpisDiv.appendChild(placeName)


    let eventWorkout=document.createElement('div')
    eventWorkout.classList.add('zajecia')

    eventWorkout.appendChild(zajeciaImgDiv)
    eventWorkout.appendChild(zajeciaOpisDiv)

    while(lightbox.firstChild){
      lightbox.removeChild(lightbox.firstChild)
    }
    lightbox.appendChild(eventWorkout)
  })
})

lightbox.addEventListener('click', e => {
  if (e.target !== e.currentTarget) return
  lightbox.classList.remove('active')
})