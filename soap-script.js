const { createApp, ref } = Vue

console.log("aaaaaaaaaaaa");

createApp({
	setup() {
		const message = ref('Hello Vue!')
		return {
			message
		}
	}
}).mount('#app')