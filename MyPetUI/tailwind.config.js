/** @type {import('tailwindcss').Config} */
module.exports = {
  content: [
    "./src/**/*.{html,ts}",
  ],
  theme: {
    extend: {
      screens: {
        'xl': '1500px',
      },
      colors: {
        'primarybleu': '#8fa1f7',
        'secondbleu': '#bbc7fb',
        'thirdbleu': '#e2e6ff',
      },
    },
  },
  plugins: [require('@tailwindcss/forms')],
}
