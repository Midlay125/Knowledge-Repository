// script.js

// Enable hover on dropdown submenu
document.querySelectorAll('.dropdown-submenu').forEach((submenu) => {
  submenu.addEventListener('mouseenter', function () {
    const dropdown = this.querySelector('.dropdown-menu');
    if (dropdown) {
      dropdown.classList.add('show');
    }
  });
  submenu.addEventListener('mouseleave', function () {
    const dropdown = this.querySelector('.dropdown-menu');
    if (dropdown) {
      dropdown.classList.remove('show');
    }
  });
});
