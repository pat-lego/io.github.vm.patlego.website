import Card from '@/components/Card.vue'
import { shallowMount } from '@vue/test-utils'

describe('Card.vue with card', () => {
  it('render card', () => {
    const wrapper = shallowMount(Card, {
      propsData: {
        card: {
          imageUrl: 'profile.jpg',
          imageAlt: 'Alternative Text',
          imageTitle: 'This is my title'
        }
      }
    })
    expect(wrapper).toBeTruthy()
    expect(wrapper.html()).toContain('This is my title')
    expect(wrapper.html()).toContain('Alternative Text')
  })

  it('render card without card', () => {
    const wrapper = shallowMount(Card)
    expect(wrapper.html()).not.toContain('This is my title')
    expect(wrapper.html()).not.toContain('Alternative Text')
  })
})
