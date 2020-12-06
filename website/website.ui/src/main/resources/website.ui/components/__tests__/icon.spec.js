import Icon from '@/components/Icon.vue'
import { shallowMount } from '@vue/test-utils'

describe('Icon.vue', () => {
  it('validate name', () => {
    const wrapper = shallowMount(Icon, {
      stubs: ['router-link']
    })
    expect(wrapper.html()).toContain('Pat Lego')
  })
})
