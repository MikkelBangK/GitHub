document.addEventListener('DOMContentLoaded', () => {
    const form = document.getElementById('personForm');
    const tilfoejKnap = document.getElementById('tilfoejKnap');
    const personListe = document.getElementById('personListe');

    tilfoejKnap.addEventListener('click', () => {
        const fornavn = document.getElementById('fornavn').value;
        const efternavn = document.getElementById('efternavn').value;

        if (fornavn && efternavn) {
            const listItem = document.createElement('li');
            listItem.textContent = `${fornavn} ${efternavn}`;

            listItem.addEventListener('click', () => {
                listItem.classList.toggle('highlighted');
            });

            personListe.appendChild(listItem);

            form.reset();
        } else {
            alert('Begge felter skal udfyldes.');
        }
    });
});