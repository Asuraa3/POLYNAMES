// Ajoutez votre logique JavaScript ici
document.addEventListener('DOMContentLoaded', () => {
    const grid = document.getElementById('grid');
    if (grid) {
        // Exemple de génération de grille (à personnaliser selon les besoins)
        for (let i = 0; i < 25; i++) {
            const cell = document.createElement('div');
            cell.className = 'cell';
            cell.innerText = `Mot ${i + 1}`;
            grid.appendChild(cell);
        }
    }
});
