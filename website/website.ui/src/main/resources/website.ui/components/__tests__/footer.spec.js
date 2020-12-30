import { shallowMount } from '@vue/test-utils'
import Footer from '@/components/Footer.vue'
import { FontAwesomeIcon } from '@fortawesome/vue-fontawesome'

describe('Footer.vue', () => {
  it('props should appear', async () => {
    const footer = {
      linkedin: 'my linkedin',
      github: 'my github',
      stackoverflow: 'my stackoverflow',
      twitter: 'my twitter'
    }
    const wrapper = shallowMount(Footer, {
      components: {
        FontAwesomeIcon
      }
    })
    await wrapper.setData(footer)

    expect(wrapper.html()).toContain(footer.linkedin)
    expect(wrapper.html()).toContain(footer.twitter)
    expect(wrapper.html()).toContain(footer.stackoverflow)
    expect(wrapper.html()).toContain(footer.github)
  })
})
